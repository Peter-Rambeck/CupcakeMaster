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
        Saldo
    </div>
    <div class="col-md-3">
           Indsæt betaling
    </div>

</div>
<hr>
<c:forEach  items="${requestScope.customers}" var="customer" varStatus="loop">
    <div class="row">
        <div class="col-md-3">
             ${customer.customerId}
        </div>
        <div class="col-md-3">
            ${customer.email}
        </div>
        <div class="col-md-3">
            ${customer.saldo}
        </div>
        <div class="col-md-3">
        <form method="post">
            <input type="hidden" name="customer_id" value="${customer.customerId}">
            <input type="text" class="form-control" aria-describedby="cashPayment" name="paid">
        </form>
        </div>
    </div>
    <hr>
</c:forEach>



</div>