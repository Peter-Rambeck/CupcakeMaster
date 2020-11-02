<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="cupcakeMaster.infrastructure.DBTopRepository" %>

<div class="row">
    <h1>Velkommen ombord</h1>
    <br>
</div>

<div class="row">
    <h3 >Øens bedste Cupcakes.<br/>
        Vælg og bestil her</h3>
</div>

<%
    //request.setAttribute("bottoms", );
    // request.setAttribute("toppings", LogicFacade.getAllToppings());
%>

<form method="post">
    <input type="hidden" name="target" value="shoppingCart">
    <div class="row">

        <div class="col-md-4">
            <!-- Dropdown numbers -->
            <div class="form-group ">
                <label for="numberOfCupcakes">Angiv antal</label>
                <select class="form-control" name="number" id="numberOfCupcakes">
                    <c:forEach var = "i" begin = "1" end = "12">
                        <option value="${i}">
                           ${i}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="col-md-4">
            <!-- Dropdown bottoms -->
            <div class="form-group">
                <label for="selectBottom">Select Cupcake bottom</label>
                <select class="form-control" name="bottom" id="selectBottom">
                    <c:forEach  items="${requestScope.bottom}" var="bot">
                        <option value="${bot.id}">
                                ${bot.name} ${bot.price} kr
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="col-md-4">

            <!-- Dropdown toppings -->
            <div class="form-group">
                <label for="selectTopping">Select Cupcake topping</label>
                <select class="form-control" name="topping" id="selectTopping">
                    <c:forEach  items="${requestScope.topping}" var="top">
                        <option value="${top.id}">
                                ${top.name} ${top.price} kr
                        </option>
                    </c:forEach>

                </select>
            </div>

        </div>

    </div>

    <div class="text-right">
        <button type="submit" class="btn btn-primary" name="order">Add to order</button>
    </div>

</form>


<div class="row">
    <h1 class="text-center">Din bestilling</h1>
    <br>
</div>
<div class="row">
    <h3 class="text-center">Slet, ret eller tilføj til din ordre.</h3>
    <br>
    <br>
</div>

<div class="row">
    <div class="col-md-2">
        Cupcakes
    </div>
    <div class="col-md-2">
        Bottom
    </div>
    <div class="col-md-2">
        Topping
    </div>
    <div class="col-md-2">
        Price
    </div>
   </div>
<hr>

<c:forEach items="${sessionScope.shoppingCart}" var="ordreLinje" varStatus="loop">
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
        <div class="col-md-4">
            <form method="post" >
                <input type="hidden" name="delete" value="${loop.index}">
                <button type="submit" class="btn btn-primary" >Delete</button>
            </form>
        </div>
        </div>
        </form>
        </div>
    </div>
</c:forEach>
<hr>


<form method="post">
    <input type="hidden" name="target" value="bestil">
</div>
    <div class="text-right">
        <button type="submit" class="btn btn-primary">Buy order</button>
    </div>
</form>

