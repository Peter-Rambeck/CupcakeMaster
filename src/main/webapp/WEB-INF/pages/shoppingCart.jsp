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
                        <option value="${bot}">
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
                        <option value="${top}">
                                ${top.name} ${top.price} kr
                        </option>
                    </c:forEach>

                </select>
            </div>

        </div>

    </div>

    <div class="text-right">
        <input type="submit" class="btn btn-primary" value = "Tilføj til ordre" />
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
    <div class="col-md-2">
        Change
    </div>
    <div class="col-md-2">
        Delete
    </div>
</div>
<hr>

<div class="row">
    <div class="col-md-2">
        ${requestScope.number}
    </div>
    <div class="col-md-2">
        ${requestScope.number}
    </div>
    <div class="col-md-2">
        ${requestScope.number}
    </div>
    <div class="col-md-2">
        N/A
    </div>
    <div class="col-md-2">
        N/A
    </div>
    <div class="col-md-2">
        N/A
    </div>
</div>

<hr>



</div>


<div class="text-left">
    <a class="btn btn-primary" href="FrontController?target=redirect&destination=index" role="button">Add Cupcakes</a>
</div>
