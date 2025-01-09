package douglas.javacrud.type;


import lombok.Getter;

@Getter
public enum EmployeePosition {
    ENGINEER(1), POLICE(2),DEVELOPMENT(3);
    private final int value;

    EmployeePosition(int value){
        this.value = value;
    }

}
