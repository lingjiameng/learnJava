# 运行java程序
java -cp app.jar:a.jar:b.jar:c.jar com.liaoxuefeng.sample.Main

# 编译java程序为字节码
javac -d bin src/module-info.java src/com/ljmeng/sample/*.java

# 打包字节码为jar包
jar --create --file hello.jar --main-class com.ljmeng.sample.Main -C bin .

# 创建模块
jmod create --class-path hello.jar hello.jmod

# 执行模块
java --module-path hello.jar --module hello.world

# 打包模块为可分发程序
jlink --module-path hello.jmod --add-modules java.base,java.xml,hello.world --output jre/