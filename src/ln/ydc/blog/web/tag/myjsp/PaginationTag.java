package ln.ydc.blog.web.tag.myjsp;


import javax.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

import javax.servlet.jsp.JspContext;  
import javax.servlet.jsp.JspException;  
import javax.servlet.jsp.JspWriter; 
import common.util.Pagination;

public class PaginationTag extends SimpleTagSupport {
	 /** 
     * 分页数据(required) 
     */  
    private Pagination pagination;  
    /** 
     * 查询form的Id,默认为queryForm 
     */  
    private String queryForm = "queryForm";  
    /** 
     * 分页div,默认为paginationId 
     */  
    private String divId = "paginationId";  
    /** 
     * 分页样式,默认为technorati 
     */  
    private String divClass = "technorati"; 
    public void doTag() throws JspException, IOException {  
        // 参数验证  
          
        StringBuffer strBuf = new StringBuffer();  
        strBuf.append("<script type=\"text/javascript\">");  
        strBuf.append("var paga_queryForm = document.forms['").append(queryForm).append("'];");  
                  
                /* 
                strBuf.append("var newInput = document.createElement('input');"); 
        strBuf.append("newInput.type='hidden';"); 
        strBuf.append("newInput.name='pageNo';"); 
        strBuf.append("paga_queryForm.appendChild(newInput);"); 
                */  
        strBuf.append("function paga_toPage(pageNo) {");  
        strBuf.append("paga_queryForm.pageNo.value=").append("pageNo;");  
        strBuf.append("paga_queryForm.submit();");  
        strBuf.append("}");  
        strBuf.append("</script>");  
  
        strBuf.append("<div id=\"").append(divId).append("\" class=\"").append(divClass).append("\">");  
          
        // 上一页  
        if (pagination.getPageNo() == 1) {  
            // strBuf.append(" <a href=\"#\"><span class=\"first_link\">首页</span></a> ");  
            strBuf.append(" <span class=\"disabled\">").append(" << </span> ");  
        } else {  
            // strBuf.append(" <a href=\"#\" onclick=\"paga_toPage(1);\"><span class=\"first_link\">首页</span></a> ");  
            strBuf.append(" <a href=\"#\" onclick=\"paga_toPage(").append(pagination.getPageNo() - 1).append(")\"> << </a> ");  
        }  
  
        for (int i = pagination.getStartIndex(); i <= pagination.getEndIndex(); i++) {  
            if (pagination.getPageNo() == i) {  
                strBuf.append("<span class=\"current\">").append(i).append("</span>");  
            } else {  
                strBuf.append("<a href=\"#\"").append(" onclick=\"paga_toPage(").append(i).append(");\">").append(i).append("</a>");  
            }  
        }  
  
        // 下一页  
        if (pagination.getPageNo() == pagination.getTotalPage()) {  
            strBuf.append(" <span class=\"disabled\">").append(" >> </span> ");  
            // strBuf.append(" <a href=\"#\"><span class=\"end_link\">末页</span></a> ");  
        } else {  
            strBuf.append(" <a href=\"#\" onclick=\"paga_toPage(").append(pagination.getPageNo() + 1).append(")\"> >> </a> ");  
            // strBuf.append(" <a href=\"#\" onclick=\"paga_toPage(").append(pagination.getTotalPage()).append(")\"><span class=\"end_link\">末页</span></a> ");  
        }  
        strBuf.append("<span class=\"info\">(第").append(pagination.getPageNo()).append("/").append(pagination.getTotalPage()).append("页").append(" 共").append(pagination.getTotalRecord()).append(  
                "条)</span>");  
  
        strBuf.append("</div>");  
        // System.out.println(strBuf.toString());  
        JspContext ctx = getJspContext();  
        JspWriter out = ctx.getOut();  
        out.print(strBuf.toString());  
    }  
    public Pagination getPagination() {  
        return pagination;  
    }  
  
    public void setPagination(Pagination pagination) {  
        this.pagination = pagination;  
    }  
  
    public String getQueryForm() {  
        return queryForm;  
    }  
  
    public void setQueryForm(String queryForm) {  
        this.queryForm = queryForm;  
    }  
  
    public String getDivId() {  
        return divId;  
    }  
  
    public void setDivId(String divId) {  
        this.divId = divId;  
    }  
  
    public String getDivClass() {  
        return divClass;  
    }  
  
    public void setDivClass(String divClass) {  
        this.divClass = divClass;  
    }  
}
