Halbuilder is a simple Java API for generating and consuming HAL documents conforming to the
[HAL Specification](http://stateless.co/hal_specification.html).

    ResourceFactory resourceFactory = new ResourceFactory();

    Resource owner = resourceFactory.newHalResource("http://example.com/mike")
      .withLink("td:friend", "http://example.com/mamund")
      .withProperty("name", "Mike")
      .withProperty("age", "36");

    Resource halResource = resourceFactory.newHalResource("http://example.com/todo-list")
      .withNamespace("td", "http://example.com/todoapp/rels/")
      .withLink("td:search", "/todo-list/search;{searchterm}")
      .withLink("td:description", "/todo-list/description")
      .withProperty("created_at", "2010-01-16")
      .withProperty("updated_at", "2010-02-21")
      .withProperty("summary", "An example list")
      .withSubresource("td:owner", owner);

    String xml = halResource.renderContent(ResourceFactory.HALXML);
    String json = halResource.renderContent(ResourceFactory.HALJSON);
