package com.ljmeng.sample;

import javax.xml.XMLConstants;

class Main{
    public static void main(String[] args) {
        Greeting g = new Greeting();
        g.hello(XMLConstants.XML_NS_PREFIX);
    }
}