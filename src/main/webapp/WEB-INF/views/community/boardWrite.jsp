<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<script>
    //Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation')

            // Loop over them and prevent submission
            Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
        }, false)
    }())
</script>
<div class="container">
    <div class="row">
        <div class="col-md-12 order-md-1">
            <h4 class="mb-5">Board</h4>
            <form class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-12 mb-3">
                        <label for="firstName">board name</label> <input type="text" class="form-control" id="firstName"
                            placeholder="Board name" value="" required>
                        <div class="invalid-feedback">Valid first name is required.
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="username">board content</label>
                    <div class="input-group">
                        <textarea rows="20" cols="100" class="form-control" id="username" placeholder="Board content"
                            required></textarea>
                        <div class="invalid-feedback" style="width: 100%;">Your
                            username is required.</div>
                    </div>
                </div>


                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Write</button>
            </form>
        </div>
    </div>
</div>

<%@include file="../include/footer.jsp"%>