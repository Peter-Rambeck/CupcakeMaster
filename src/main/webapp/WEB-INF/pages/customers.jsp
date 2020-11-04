<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8"%>
<div class="row">
    <h1>Administration</h1>
    <br>
</div>
<div class="row">
    <h3 >Alle kunder <br/>
        Liste af kunder og udestående</h3>
</div>

<div class="row">
    <hr>
    <br>
</div>
<div class="row">
    <div class="col-md-3">
        Kunde ID
    </div>
    <div class="col-md-3">
        Email
    </div>
    <div class="col-md-3">
        udestående
    </div>
    <div class="col-md-3">
        <form method="post">
            <label for="payment">Indsæt betaling</label>
            <input type="text" class="form-control" id="payment"
                   aria-describedby="cashPayment" name="paid">
            <button type="submit" class="btn btn-light">Betal</button>
        </form>
    </div>

</div>
<hr>
<div class="row">
    <div class="col-md-3">
        N/A
    </div>
    <div class="col-md-3">
        N/A
    </div>
    <div class="col-md-3">
        N/A
    </div>
    <div class="col-md-3">
        N/A
    </div>

    </div>
</div>
<hr>
</div>
<div class="row" style="align-content: center">
    <a class="btn btn-primary" role="button">Afslut</a>
</div>



