module.exports = function(grunt) {

    grunt.initConfig({
	sass : {
	    options : {
		
	    },
	    build : {
		files : {
		    'assets/css/blog.css' : 'assets/sass/blog.css'
		}
	    }
	},
	watch : {
	    files : [ 'assets/sass/*' ],
	    tasks : [ 'sass' ]
	}
    });

    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-sass');

};