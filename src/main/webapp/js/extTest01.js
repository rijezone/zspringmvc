Ext.onReady(function(){
    	Ext.MessageBox.alert("hello","helloworld");
    	
    	var myPanel = new Ext.Panel({
    		renderTo:"myPanel",
    		title:"hello",
    		width:400,
    		height:300,
    		html:"hello,world"
    	});
    	
    	var myTabPanel = new Ext.TabPanel({
    		renderTo:"myTabPanel",
    		title:"helloTabPanel",
    		width:400,
    		height:300,
    		activeTab:0,
    		items:[ new Ext.Panel({
    					title:"a",
    					height:30,
    					html:"aaaaaaaaaaaaaaa"
    				}),
    				new Ext.Panel({
    					title:"b",
    					height:30,
    					html:"bbbbbbbbbbbbbbb"
    				}),
    				new Ext.Panel({
    					title:"c",
    					height:30,
    					html:"ccccccccccccccc"
    				}),
    				{title:"d",
    				 xtype:"htmleditor"}
    			  ]
    	});
    });