var chart_config = {
    chart: {
        container: "#tree-simple"
    },

    nodeStructure: {
        text: { name: "Parent node" },
        children: [
            {
                text: { name: "First child" },
                children: [
                    {
                        text: { name: "First grandchild" }
                    },
                    {
                        text: { name: "Second grandchild" }
                    }
                ]
            },
            {
                text: { name: "Second child" }
            },
            {
                text: { name: "Third child" }
            }
        ]
    }
};

//var chart = new Treant(simple_chart_config, function() { alert( 'Tree Loaded' ) }, $ );