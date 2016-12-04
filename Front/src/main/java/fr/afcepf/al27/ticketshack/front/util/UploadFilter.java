package fr.afcepf.al27.ticketshack.front.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFilter implements Filter {
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest)request;

        boolean isMultipartContent = ServletFileUpload.isMultipartContent(httpRequest);

        if (!isMultipartContent) {
            chain.doFilter(request, response);
            return;
        }        

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            upload.setSizeMax(-1);

            List<FileItem> items = upload.parseRequest(httpRequest);
            final Map<String, String[]> parameterMap = new HashMap<String, String[]>();

            for (FileItem item : items) {
                if (item.isFormField()) {
                    processFormField(item, parameterMap);
                } else {
                    processFileField(item, httpRequest);
                }
            }

            chain.doFilter(new HttpServletRequestWrapper(httpRequest) {

                    public Map<String, String[]> getParameterMap() {
                        return parameterMap;
                    }

                    public String[] getParameterValues(String name) {
                        return (String[])parameterMap.get(name);
                    }

                    public String getParameter(String name) {
                        String[] params = getParameterValues(name);
                        if (params == null) {
                            return null;
                        }
                        return params[0];
                    }

                    public Enumeration<String> getParameterNames() {
                        return Collections.enumeration(parameterMap.keySet());
                    }
                }, response);
        } catch (Exception ex) {
            ServletException servletException = new ServletException();
            servletException.initCause(ex);
            throw servletException;
        }
    }

    private void processFormField(FileItem formField, Map<String, String[]> parameterMap) {
        String name = formField.getFieldName();
        String value = formField.getString();
        String[] values = parameterMap.get(name);

        if (values == null) {
            parameterMap.put(name, new String[] { value });
        } else {
            int length = values.length;
            String[] newValues = new String[length + 1];
            System.arraycopy(values, 0, newValues, 0, length);
            newValues[length] = value;
            parameterMap.put(name, newValues);
        }
    }

    private void processFileField(FileItem fileField, HttpServletRequest request) {
        if (request.getAttribute(fileField.getFieldName()) == null) {
            List<FileItem> fileFields = new ArrayList<FileItem>(0);
            fileFields.add(fileField);
            request.setAttribute(fileField.getFieldName(), fileFields);
        } else {
            List<FileItem> fileFields = (List<FileItem>)request.getAttribute(fileField.getFieldName());
            fileFields.add(fileField);
        }
    }
}