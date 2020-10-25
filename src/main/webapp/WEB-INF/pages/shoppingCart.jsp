<%@ page contentType="text/html;charset=UTF-8"%>

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
        ${requestScope.bottom}
    </div>
    <div class="col-md-2">
        ${requestScope.topping}
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
