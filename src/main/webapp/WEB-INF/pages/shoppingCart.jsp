<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="cupcakeMaster.infrastructure.DBTopRepository" %>



<div class="row">
    <h1>Velkommen ombord</h1>
    <br>
</div>

<div class="row">
    <h3 >Øens bedste Cupcakes.<br/>
        Vælg og bestil her</h3>
</div>

<form method="post">
    <input type="hidden" name="target" value="shoppingCart">
    <div class="row">

        <div class="col-md-4">
            <!-- Dropdown numbers -->
            <div class="form-group ">
                <label for="numberOfCupcakes">Angiv antal</label>
                <select class="form-control" name="number" id="numberOfCupcakes">
                    <option value="1">
                        1
                    </option>
                    <option value="2">
                        2
                    </option>
                    <option value="3">
                        3
                    </option>
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
        <button type="submit" class="btn btn-primary">Add to order</button>
    </div>

</form>

<form method="post">
    <input type="hidden" name="target" value="bestil">

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

    <div class="col-md-3">
        Price
    </div>
    <div class="col-md-3">
        Delete
    </div>
</div>
<hr>

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

        <div class="col-md-3">
            ${(ordreLinje.bottom.price+ordreLinje.top.price)*ordreLinje.quantity}
        </div>

        <div class="col-md-3">
            Delete
        </div>


    </div>
</c:forEach>
<hr>



<div class="text-right">
    <button type="submit" class="btn btn-primary">Bestil</button>
</div>
</form>