<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<div class="row">
    <h1>Administration</h1>
    <br>
</div>
<div class="row">
    <h3 >Alle ordrer <br/>
        Afslut ordre ved betaling</h3>
</div>
<div class="row">
    <hr>
    <br>
</div>
<div class="row">
    <div class="col-md-1">
        Bestillings nummer
    </div>
    <div class="col-md-2">
        Afhentningdato
    </div>
    <div class="col-md-2">
        Email
    </div>
    <div class="col-md-2">
        Antal cupcakes
    </div>
    <div class="col-md-1">
        Pris
    </div>
    <div class="col-md-1">
        <a class="btn btn-light" href="" role="button">Vis ordre</a>
    </div>
    <div class="col-md-2">
        <form method="post">

            <label for="payment">Indsæt betaling</label>
            <input type="text" class="form-control" id="payment"
                   aria-describedby="cashPayment" name="paid">
            <button type="submit" class="btn btn-light">Betal</button>
        </form>

    </div>
    <div class="col-md-1">
        Afhentet
    </div>
</div>
<hr>
<div class="row">
    <div class="col-md-1">
        ${requestScope.orderID}
    </div>
    <div class="col-md-2">
        ${requestScope.pickupDate}
    </div>
    <div class="col-md-2">
        ${requestScope.email}
    </div>
    <div class="col-md-2">
        ${requestScope.quantity}
    </div>
    <div class="col-md-1">
        ${requestScope.price}
    </div>
    <div class="col-md-1">
       N/A
    </div>
    <div class="col-md-2">
        N/A
    </div>
    <div class="col-md-1">
        N/A
    </div>
</div>
<hr>
</div>
<div class="row" style="align-content: center">
    <a class="btn btn-primary" role="button">Afslut</a>
</div>


