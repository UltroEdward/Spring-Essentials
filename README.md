# Spring fundamentals in action

## xml-configuration  
Spring app demo configured with xml-configuration  

-beans configured with constructor  
-beans configured with setters  
-beans configured with factory method  

-beans with singleton/prototype scopes  

-bean auto-wired by type  
-bean auto-wired by name  
-bean auto-wired by constructor  

-beans configured with SpEL 
 
-beans configured with init-method/destroy-methods  
-beans configured as parent/child  

-replaced methods  

## annotation-configuration   
Annotaions ONLY based configuration  

-beans with autowiring (@Autowired)  
-beans with qualifier (@Qualifier("name"))  
-beans with value (@Value("name"))  
-beans with value (@Value("name")) + SpEL  

-beans with @PreDestroy/@PostConstruct methods

-beans with @Scope singleton/prototype

-xml base config with: context:annotation-config  
-xml base config with: context:component-scan  
-xml base config with: context:include-filter 
 