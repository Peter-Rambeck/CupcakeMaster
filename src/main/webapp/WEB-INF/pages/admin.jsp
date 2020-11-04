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
        <form method="post" >
         <input type="hidden" name="vis" value="${order.ordre_id}">
         <button type="submit" class="btn btn-primary" >Vis</button>
       </form>
    </div>
    <div class="col-md-2">
        <form method="post" >
            <input type="hidden" name="afslut" value="${order.ordre_id}">
            <button type="submit" class="btn btn-primary" >Afslut</button>
        </form>
    </div>
    <div class="col-md-1">
        <form method="post" >
            <input type="hidden" name="delete" value="${order.ordre_id}">
            <button type="submit" class="btn btn-primary" >Delete</button>
        </form>
    </div>

</div>

<hr>
</div>
    <c:if test="${order.ordre_id==sessionScope.orderToShow}">
        <div class="row">
            <div class="col-md-3">
                    antal
            </div>
            <div class="col-md-3">
                    bund
            </div>
            <div class="col-md-3">
                    top
            </div>
            <div class="col-md-3">
                    pris
            </div>

        </div>
        <c:forEach items="${sessionScope.orderlinestoshow}" var="ordreLinje" varStatus="loop">
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
            </form>
            </div>
            </div>
        </c:forEach>
        <br>
    </c:if>
</c:forEach>





</div>
<hr>


<hr>

