module.exports = function(grunt) {

    grunt.initConfig({
	sass : {
	    options : {
		
	    },
	    build : {
		files : {
		    'assets/theme/hellish-simplicity/style.css' : 'assets/theme/hellish-simplicity/style.scss'
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