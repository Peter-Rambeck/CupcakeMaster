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

<c:forEach items="${sessionScope.shoppingCart}" var="cupcake">
    <div class="row">
        <div class="col-md-2">
                N/A
        </div>
        <div class="col-md-2">
            ${requestScope.ordrelinier.size()}
        </div>
        <div class="col-md-2">
                ${requestScope.date}
        </div>
        <div class="col-md-2">
                ${requestScope.email}

        </div>
        <div class="col-md-2">
                ${requestScope.ordrelinier.size()}
        </div>
        <div class="col-md-2">
            N/A
        </div>
    </div>
</c:forEach>
<hr>



</div>


<div class="row" style="align-content: center">

    <a class="btn btn-primary" href="shoppingCart" role="button">Til shoppingcart</a>
    <br>

    <a class="btn btn-primary" role="button">Afslut</a>
</div>