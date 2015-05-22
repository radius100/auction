<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="..//layout/taglib.jsp"%>

<c:if test="${param.success eq true}">
	<div class="alert alert-success" align="center">Пользователь зарегистрирован успешно!</div>
</c:if>


<spring_form:form commandName="_user" cssClass="form-horizontal myRegForm">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-4">
			<spring_form:input path="name" cssClass="form-control" />
			<spring_form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-4">
			<spring_form:input path="email" cssClass="form-control" />
			<spring_form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-4">
			<spring_form:password path="password" cssClass="form-control" />
			<spring_form:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password again</label>
		<div class="col-sm-4">
			<input type="password" name="password_again" id="password_again" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>
</spring_form:form>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".myRegForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3
				},
				email: {
					required : true,
					email: true
				},
				password: {
					required : true,
					minlength : 5
				},
				password_again: {
					required : true,
					minlength : 5,
					equalTo: "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}

		}
	);
});
</script>			