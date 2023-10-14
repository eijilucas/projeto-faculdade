
package com.projetofaculdade.fasterfood.entities;

public enum OrderStatus {
    
    RECEIVED(1),
    CONFIRMED(2),
    PREPARED(3),
    DELIVERED(4),
    CANCELED(5);
    
    private final int code;
    
    private OrderStatus(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código OrderStatus inválido.");
    }
}
