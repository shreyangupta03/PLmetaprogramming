# Running the code
- Start a new project by running `lein new app projectname` on the terminal.
- Copy the code from desired `core.clj` into `./projectname/src/projectname/core.clj`
- Replace the first line of core.clj with the project name. (example: `(ns getter-setter.core` becomes `(ns projectname.core`)
- Run the command `lein run` in the terminal to run the code.

# Getter-Setter
This program demonstrates compile-time metaprogramming by automatically generating getter and setter functions using macro expansion at compile time. This allows for easy exapnsion of the program for new attributes with a single line of code i.e `(defaccessor property)`

# Calculator
This program demonstrates both compile-time and run-time metaprogramming by generating functions that can do arithmetic with logging capability added at runtime. We can easily add more such functions by adding `(def function-name (generate-arithmetic-function (log-function function-with-logic)))`
