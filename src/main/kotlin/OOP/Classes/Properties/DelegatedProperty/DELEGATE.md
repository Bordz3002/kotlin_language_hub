<h1>Delegated Property</h1>
<h3>Definition:</h3>
<h5>A delegated property is a property that hands over (delegates) its getter/setter logic to another object</h5>
<h3>Basic Syntax:</h3>
<h5>
    Example:
    <i>var/val propertyName:Type by Delegate Object</i> - the keyword "by" means "delegate to"
    <br>
    Example: <i>var name:String by SomeDelegate()</i> - the SomeDelegate object handles the get/set
</h5>
<h3>The 3 Built-in Delegates:</h3>
<h5>
    kotlin provides the three useful delegates out-of-the-box
    <br>
    <br>
    Lazy - Computes value only when first accessed
    <br>
    Observable - Triggers code when value change
    <br>
    Vetoable - Can reject new values
</h5>