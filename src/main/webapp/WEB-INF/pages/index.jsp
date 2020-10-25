<%@ page contentType="text/html;charset=UTF-8"%>

<div class="content">
<div class="row">
    <h1>Velkommen ombord</h1>
    <br>
</div>

<div class="row">
    <h3 >Øens bedste Cupcakes.<br/>
        Vælg og bestil her</h3>
</div>

<%
    // request.setAttribute("bottoms", LogicFacade.getAllBottoms());
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
                    <c:forEach var="bottom" items="${bottoms}">
                        <option value="${bottom.name}">${bottom.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="col-md-4">
            <!-- Dropdown toppings -->
            <div class="form-group">
                <label for="selectTopping">Select Cupcake topping</label>
                <select class="form-control" name="topping" id="selectTopping">
                    <c:forEach var="topping" items="${toppings}">
                        <option value="${topping.name}">${topping.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

    </div>

    <div class="text-right">
        <button type="submit" href="" class="btn btn-primary">Go to cart</button>
    </div>

</form>

</div>

