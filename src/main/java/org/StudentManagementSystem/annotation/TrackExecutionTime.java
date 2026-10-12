package org.StudentManagementSystem.annotation;

public @interface TrackExecutionTime {
    long warnAfter() default 2000;
}
