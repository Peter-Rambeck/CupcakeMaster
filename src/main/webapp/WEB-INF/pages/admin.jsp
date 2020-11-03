<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<div class="row">
    <h1>Administration</h1>
    <br>
</div>
<div class="row">
    <h3 >Alle ordrer <br/>
        Vis og betal</h3>
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
        Vis ordre
    </div>
    <div class="col-md-2">
       Afhent
    </div>
    <div class="col-md-1">
      Slet
    </div>
</div>
<hr>


<c:forEach items="${requestScope.Orders}" var="order" varStatus="loop">
    <div class="row">
    <div class="col-md-1">
        ${order.ordre_id}
    </div>
    <div class="col-md-2">
            ${requestScope.pickupdate[loop.index]}
    </div>
    <div class="col-md-2">
            ${requestScope.email[loop.index]}
    </div>
    <div class="col-md-2">
        ${requestScope.quantity[loop.index]}
    </div>
    <div class="col-md-1">
      ${requestScope.price[loop.index]}
    </div>
    <div class="col-md-1">
        <a class="btn btn-light" href="" role="button">Vis ordre</a>
    </div>
    <div class="col-md-2">
        <a class="btn btn-light" href="" role="button">Afhent</a>    </div>
    <div class="col-md-1">
        <form method="post" >
            <input type="hidden" name="delete" value="${order.ordre_id}">
            <button type="submit" class="btn btn-primary" >Delete</button>
        </form>
    </div>

</div>

<hr>
</div>
</c:forEach>

<div class="row">
    <hr>
    <br>
</div>

<h3 >Ordrer</h3> <br/>

<div class="row">
    <div class="col-md-3">
        Antal
    </div>
    <div class="col-md-3">
        Bottom
    </div>
    <div class="col-md-3">
        Topping
    </div>
    <div class="col-md-3">
        Price
    </div>

</div>
<hr>

<c:forEach items="${sessionScope.shoppingCart}" var="ordreLinje">
    <div class="row">
        <div class="col-md-3">
                ${ordreLinje.quantity}
        </div>
        <div class="col-md-3">
                ${ordreLinje.bottom.name}
        </div>
        <div class="col-md-3">
                ${ordreLinje.top.name}
        </div>
        <div class="col-md-3">
                ${(ordreLinje.bottom.price+ordreLinje.top.price)*ordreLinje.quantity}
        </div>
    </div>
</c:forEach>
<hr>

