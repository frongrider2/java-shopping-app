<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
    <c:when test="${cart==null || empty cart.allItem}">
        <h3 class="text-danger">No item in your shopping cart</h3>
    </c:when>
    <c:otherwise>
        <table class="table table-striped table-bordered w-100">
            <thead>
            <th>#</th>
            <th>Code</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Update</th>
            </thead>
            <tbody>
            <c:forEach items="${cart.allItem}" var="lineItem" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${lineItem.product.id}</td>
                    <td>${lineItem.product.productName}</td>
                    <td>${lineItem.quantity}</td>
                    <td>${lineItem.product.msrp}</td>
                    <td> <fmt:formatNumber pattern="#.00" value="${lineItem.total}"/></td>
                    <td>
                        <div class="flex-box">
                            <span class="iconify" data-icon="ant-design:delete-filled" onclick="updateToCart('${lineItem.product.id}','remove')"></span>
                            <span class="iconify" data-icon="akar-icons:circle-plus-fill" onclick="updateToCart('${lineItem.product.id}','add')"></span>
                            <span class="iconify" data-icon="akar-icons:circle-minus-fill" onclick="updateToCart('${lineItem.product.id}','reduce')"></span>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" style="text-align: right;margin-right: 5px">Total</td>
                <td>
                     <fmt:formatNumber pattern="#,###.##" value="${cart.totalPrice}"/>
                </td>
            </tr>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>