## Operations

Open your command prompt and `cd` into this README's directory (operations). In the src path is a file named `Operations.java`. Open it and fill in the portions of the code where the comments have indicated.

When you've completed your work, test your code by compiling it with the following command:

``` bash
$ javac -d bin/ -classpath libs/test_jar.jar src/com/bloc/ops/Operations.java
```

Correct any and all errors that appear. If something goes wrong during compilation, it will be a result from the new code.

After it returns successfully, `cd` into the bin directory:

``` bash
$ cd bin/
```

From within bin, run the following command:

``` bash
# Replace ':' with ';' on Windows machines
$ java -cp .:../libs/test_jar.jar com.bloc.ops.Operations
```

If you see a success message, you've rocked it! Commit your changes and push them to Github.