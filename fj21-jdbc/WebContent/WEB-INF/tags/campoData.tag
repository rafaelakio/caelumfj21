<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="id" required="true" description="id da Data" %>
<%@ attribute name="formatDate" required="false" description="formato da Data" %>
<%@ attribute name="value" required="false" description="valor da Data" %>
<input type="text" id="${id }" name="${id }" value="${value }"/>
<script type="text/javascript">
var formatoTag="${formatDate}";
var formato="dd/mm/yy";
function c(){
	if (formatoTag!=""){
		formato=formatoTag;
	}
}
c();
$("#${id}").datepicker({
	dateFormat: formato
});
</script>