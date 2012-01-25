package com.theoryinpractise.halbuilder;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Multimap;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: amrk
 * Date: 25/01/12
 * Time: 10:43 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReadableResource {
    String getHref();

    Map<String, String> getNamespaces();

    Multimap<String, String> getLinks();

    Map<String, Object> getProperties();

    Multimap<String, ReadableResource> getResources();

    <T> Optional<T> renderClass(Class<T> anInterface);

    String renderJson();

    String renderXml();

    String renderHtmlMicroData();

    <T> boolean isSatisfiedBy(Contract contract);

    <T, V> Optional<V> ifSatisfiedBy(Class<T> anInterface, Function<T, V> function);
}
