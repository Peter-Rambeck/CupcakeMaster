<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<div class="row">
    <h1>Administration</h1>
    <br>
</div>
<div class="row">
    <h3 >Alle kunder <br/>
        Liste af kunder og udestående</h3>
</div>

<div class="row">
    <hr>
    <br>
</div>
<div class="row">
    <div class="col-md-3">
        Kunde ID
    </div>
    <div class="col-md-3">
        Email
    </div>
    <div class="col-md-3">
        udestående
    </div>
    <div class="col-md-3">
           Indsæt betaling
    </div>

</div>
<hr>
<div class="row">
    <div class="col-md-3">
        <c:forEach  items="${requestScope.customers}" var="customer">
            <option value="${customerId}">
                    ${customer.customerId}
            </option>
        </c:forEach>
    </div>
    <div class="col-md-3">
        <c:forEach  items="${requestScope.customers}" var="customer">
            <option value="${customerId}">
                    ${customer.email}
            </option>
        </c:forEach>
    </div>
    <div class="col-md-3">
            <c:forEach  items="${requestScope.customers}" var="customer">
                <option value="${customerId}">
                        ${customer.saldo}
                </option>
            </c:forEach>
    </div>
    <div class="col-md-3">
        <form method="post">
            <input type="number" class="form-control" id="payment"
                   aria-describedby="cashPayment" name="paid">
        </form>
    </div>

    </div>
</div>
<hr>
</div>