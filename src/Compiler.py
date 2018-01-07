# coding = utf-8

import os
import sys
import configparser
from os import popen


def Complier(argv):
    if len(argv) == 0:
        print 'Welcome to Our MiniJava Complier!'
        print 'Please input configure files!'

    conf = configparser.ConfigParser()
    print conf.read(argv)

    try:
        if conf.has_option('Compile', 'bool'):
            print 'Compiling all java file'
            print popen('javac *.java'),'\n'
            print "Completed."
            print "============================================\n"

        if conf.has_option('ST', 'bool'):
            print 'Generating ST from input file'
            print popen('java main ./TestFile/test.java ./test_out.txt').read(),'\n'
            print "Completed."
            print "============================================\n"

        if conf.has_option('AST', 'bool'):
            print 'Generating AST from input file'
            try:
                if ('pygraphviz' in popen("pip list").read()):
                    print popen('python ASTDrawer.py test_out.txt test_pic/').read(),'\n'
                    print "Completed."
            except Exception:
                print "Please install python module: pygraphviz"
            print "============================================\n"
    except Exception as e:
        print e


if __name__ == '__main__':
    Complier(sys.argv[1])