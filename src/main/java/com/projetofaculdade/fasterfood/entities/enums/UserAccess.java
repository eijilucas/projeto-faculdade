
package com.projetofaculdade.fasterfood.entities.enums;

public enum UserAccess {
    
    ADMIN(1),
    EMPLOYEE(2),
    OBSERVER(3);
    
    private final int code;

    private UserAccess(int code){
        this.code = code;
    }  
    
    public int getCode() {
        return code;
    }
    
     public static UserAccess valueOf(int code) {
        for (UserAccess value : UserAccess.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código UserAccess inválido.");
    }
}
