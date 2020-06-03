package com.evobank.shopping.controllers.restful.products;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(onMethod_ = {@JsonSetter})
@ToString
final class Request {
    private String name;
}
