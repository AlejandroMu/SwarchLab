module types
{
    sequence<string> seqStrings;

    ["java:serializable:types.Test"]
    sequence<byte> Test;

    sequence<Test> Tests;



    class MyClass{
        Tests field3;
        Test field4;
        
    }

    struct MyStructure{
        seqStrings field1;
        double field2;
    }
    enum Roles {
        Admin, Stand
    }
    interface Service{
        Test method(Tests param1, int num);
    }
}