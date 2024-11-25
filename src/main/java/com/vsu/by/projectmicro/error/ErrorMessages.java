package com.vsu.by.projectmicro.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessages {
    public static final String RESOURCE_NOT_FOUND_BY_ID_MESSAGE = "%s with id %d does not exist";
    public static final String RESOURCE_NOT_FOUND_BY_CUSTOMER_NAME_MESSAGE = "%s with customer name %s does not exist";
    public static final String DUPLICATE_RESOURCE_MESSAGE = "%s with this %s already exists";
}
