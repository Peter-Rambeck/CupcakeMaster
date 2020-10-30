<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>


<div class="row">
    <h1>Kunde homepage</h1>
    <br>
</div>

<div class="row">
    <h3 >${sessionScope.email}<br/>
        Tak for din ordre</h3>
</div>

<div class="row">
    <c:forEach items="${sessionScope.shoppingCart}" var="ordreLinje">
        <div class="row">
            <div class="col-md-2">
                    ${ordreLinje.quantity}
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
