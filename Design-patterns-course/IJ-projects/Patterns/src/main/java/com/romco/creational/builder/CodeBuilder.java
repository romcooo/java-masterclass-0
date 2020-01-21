package com.romco.builder;

import java.util.HashMap;
import java.util.Map;

public class CodeBuilder
{
    private String className;
    private Map<String, String> fields = new HashMap<>();
    public CodeBuilder(String className)
    {
        this.className = className;
    }
    
    public CodeBuilder addField(String name, String type)
    {
        fields.put(type, name);
        return this;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("public class ");
        sb.append(className).append("\n{\n");
        for (String key : fields.keySet()) {
            sb.append("  public ")
                    .append(key)
                    .append(" ")
                    .append(fields.get(key))
                    .append(";\n");
        }
        sb.append("}");
        return sb.toString();
    }
    
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person");
        cb.addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
        
    }
}