public class OrderBy {

    private String type;
    private String orderBy;

    public OrderBy(String type, String orderBy) {
        this.type = type;
        this.orderBy = orderBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
