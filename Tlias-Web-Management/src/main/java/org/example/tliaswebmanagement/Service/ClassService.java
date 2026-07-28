package org.example.tliaswebmanagement.Service;

import org.example.tliaswebmanagement.EntityClass.Class;
import org.example.tliaswebmanagement.EntityClass.ClassQueryData;
import org.example.tliaswebmanagement.EntityClass.ClassQueryParam;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {
    ClassQueryData findAll(ClassQueryParam classQueryParam);
}
