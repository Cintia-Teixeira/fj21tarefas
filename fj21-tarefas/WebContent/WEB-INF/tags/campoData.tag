<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="id" required="false" %>
<%@ attribute name="value" required="false" %>

<input type="text" id="${id}" name="${id}" />
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});

</script>