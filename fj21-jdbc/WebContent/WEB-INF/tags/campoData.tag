<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="id" required="true" description="id da Data" %>
<%@ attribute name="formatDate" required="false" description="formato da Data" %>
<input type="text" id="${id }" name="${id }"/>
<script>
var formatoTag="${formatDate}";
var formato = function(){
		if (formatoTag==""){
			return "dd/mm/yy";
		} else {
			return formatoTag;
		}
}
$(document).ready(function() {
	$("#${id}").datepicker({
		dateFormat: formato
	});
});
</script>
