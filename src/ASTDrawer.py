# coding = utf-8

import os
import sys
import Queue
import pygraphviz


flags = ['(', ')', '[', ']', '{', '}', ' ', ',', ';', '\n']
useless = ['[', ']', '{', '}', ' ', ',', ';', '\n']
target = ['+', '-', '*', '<', '=', '&', 'if', 'while']


class Node:
    def __init__(self, name, parent, depth):
        self.n = name
        self.p = parent
        self.c = []
        self.d = depth


def getNode(line, pos):
    return line[pos+1:].split(' ')[0]


def getContent(line, pos):
    i = j = pos
    while line[j] not in flags:
        j += 1
    unit = line[i:j]
    return unit


def setName(dict, key):
    if key in dict:
        dict[key] += 1
    else:
        dict[key]=1
    return key +'\n'+ str(dict[key])


def ASTDrawer(infile, outdir):
    # Graph Setting
    AST = pygraphviz.AGraph(directed=True, strict=True)
    AST.node_attr['style'] = 'filled'
    AST.node_attr['shape'] = 'box'

    # Tree Nodes
    nodeQueue = Queue.Queue()
    nodeDict = {}
    root = setName(nodeDict, 'root')
    root = Node(root, None, 0)
    pNode = root

    depth = 0
    with open(infile) as fin:
        for line in fin:
            i = 0
            while i < len(line):
                if line[i] == '(':
                    depth += 1
                    print str(depth) + '\t('
                    if line[i+1] != ' ':
                        content = getNode(line, i)
                        i += (len(content) + 1)
                        curNode = setName(nodeDict, content)
                        curNode = Node(curNode, pNode, depth)
                        pNode.c.append(curNode)
                        pNode = curNode
                        # print 'in\t' + pNode.n + '\t' + str(pNode.d) + '\t' + str(i)
                    else:
                        i += 1
                elif line[i] == ')':
                    depth -= 1
                    print str(depth) + '\t)'
                    if depth < pNode.d:
                        # print 'out\t' + pNode.n + '\t' + str(depth) + '\t' + str(i)
                        pNode = pNode.p
                    i += 1
                elif line[i] in useless:
                    i += 1
                else:
                    content = getContent(line, i)
                    #print content
                    if content in target:
                        pNode.n = pNode.n + '\n' + content
                    i += (len(content))

    nodeQueue.put(root)
    while not nodeQueue.empty():
        pNode = nodeQueue.get()
        AST.add_node(pNode.n, color = '#3b7702')
        for node in pNode.c:
            AST.add_node(node.n, color='#3b7702')
            AST.add_edge(pNode.n, node.n)
        for node in pNode.c:
            nodeQueue.put(node)
    AST.graph_attr['epsilon'] = '0.001'
    AST.write(outdir + '/AST.dot')
    AST.layout('dot')
    AST.draw(outdir + '/AST.png')


if __name__ == '__main__':
    #ASTDrawer(sys.argv[1], sys.argv[2])
    ASTDrawer('C:\\Users\\Ash Yao\\Desktop\\Complier\\miniJava\\TestFile\\test.txt',
              'C:\\Users\\Ash Yao\\Desktop\\Complier\\miniJava\\TestFile\\')
