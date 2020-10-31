<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>

<div class="row">
    <h1>Din bestilling er modtaget</h1>
    <br>
</div>

<div class="row">
    <h3 >Ved afhentning, Venligst oplys: <br/>
        Email samt bestillingsnummer</h3>
</div>

<div class="row">
    <hr>
    <br>
</div>

<div class="row">
    <div class="col-md-2">
        Bestillings nummer
    </div>
    <div class="col-md-2">
        Bestillings dato
    </div>
    <div class="col-md-2">
        Email
    </div>
    <div class="col-md-2">
        Antal cupcakes
    </div>
    <div class="col-md-2">
        Pris
    </div>
    <div class="col-md-2">
        Afhentningdato
    </div>
</div>
<hr>

<c:forEach items="${}" var="Ordre">
    <div class="row">
        <div class="col-md-2">
                N/A
        </div>
        <div class="col-md-2">
                ${ordreLinje.bottom.name}
        </div>
        <div class="col-md-2">
                ${ordreLinje.top.name}
        </div>
        <div class="col-md-2">
                ${(ordreLinje.bottom.price+ordreLinje.top.price)*ordreLinje.quantity}
        </div>
        <div class="col-md-2">
            N/A
        </div>
        <div class="col-md-2">
            N/A
        </div>
    </div>
</c:forEach>
<hr>



</div>


<div class="text-right">
    <a class="btn btn-primary" role="button">Afslut</a>
</div>
