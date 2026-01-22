package com.hidenari;

enum GradeEnum {
    GOLD,
    SILVER,
    BRONZE;

    GradeEnum upGrade(GradeEnum grade) {
        return switch (grade) {
            case BRONZE -> SILVER;
            case SILVER -> GOLD;
            default -> throw new IllegalStateException("Unexpected value: " + grade);
        };
    }

    GradeEnum downGrade(GradeEnum grade) {
        return switch (grade) {
            case GOLD -> SILVER;
            case SILVER -> BRONZE;
            default -> throw new IllegalStateException("Unexpected value: " + grade);
        };
    }
}
