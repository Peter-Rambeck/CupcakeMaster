<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-purple bg-dark fixed-top">
    <a class="navbar-brand" href="shoppingCart">Home</a>
    <c:if test="${sessionScope.Customer.admin}" >
    <a class="navbar-brand" href="Admin">Ordrer</a>
    <a class="navbar-brand" href="Customers">Kunder</a>
    </c:if>






        <div>
            ${sessionScope.Customer.email}
        </div>
    <c:if test="${sessionScope.Customer!=null}">
    <ul class="navbar-nav ml-auto">
    <form method="post" action="<c:url value="/shoppingCart"/>" style="float: right">
        <input type="hidden" name="logout" >
        <button type="submit" class="btn btn-primary">Log Ud</button>
    </form>
    </ul>
    </c:if>


    <c:if test="${sessionScope.Customer==null}">
    <ul class="navbar-nav ml-auto">
    <div class="nav-item dropdown ">
        <a class="nav-link dropdown-toggle btn btn-primary" href="#" id="dropdown02" data-toggle="dropdown"
           aria-haspopup="true"
           aria-expanded="false">Opret Bruger</a>
        <div class="dropdown-menu dropdown-menu-right dropdown-menu-larger ">
            <form class="px-3 py-3" method="post" action="<c:url value="/shoppingCart"/>">
                <div class="form-group">
                    <label for="exampleDropdownFormEmail2">Indtast Email</label>
                    <input type="email" class="form-control" id="exampleDropdownFormEmail2"
                           name="email"
                           placeholder="email@example.com">
                </div>
                <div class="form-group">
                    <label for="exampleDropdownFormPassword2">Opret Kodeord</label>
                    <input type="password" class="form-control" id="exampleDropdownFormPassword2"
                           name="password"
                           placeholder="Kodeord">
                </div>
                <button type="submit" class="btn btn-primary">Opret Bruger</button>
            </form>
        </div>
    </div>
    </ul>
    </c:if>
    <c:if test="${sessionScope.Customer==null}">
            <div class="nav-item dropdown">
                   <a class="nav-link dropdown-toggle btn btn-primary" href="#" id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true"
                   aria-expanded="false">Log in</a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-larger">

                    <form class="px-3 py-3" method="post" action="<c:url value="/shoppingCart"/>">
                        <div class="form-group">
                            <label for="exampleDropdownFormEmail1">Email</label>
                            <input type="email" class="form-control" id="exampleDropdownFormEmail1"
                                   name="Loginemail"
                                   >
                        </div>
                        <div class="form-group">
                            <label for="exampleDropdownFormPassword1">Kodeord</label>
                            <input type="password" class="form-control" id="exampleDropdownFormPassword1"
                                   name="Loginpassword">

                        </div>
                        <button type="submit" class="btn btn-primary">Log in</button>
                    </form>
                </div>

            </div>
    </c:if>
    <!-- <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
    </div>
    -->

</nav>