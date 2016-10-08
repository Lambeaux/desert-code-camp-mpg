
var webpack = require('webpack');
var path = require('path');

var config = {
    entry: './jsx/App.jsx',
    output: {
        path: './../main/webapp/javascript',
        filename: 'bundle.js'
    },
    module : {
        loaders : [
            {
                test : /\.jsx?/,
                include : path.resolve(__dirname, 'jsx'),
                loader : 'babel',
                query: {
                    presets: ['react', 'es2015']
                }
            }
        ]
    }
};

module.exports = config;