# coding = utf-8

import os
import sys
import pygraphviz


flags = ['(', ')', '[', ']', '{' , '}', ' ', ',', ';', '\n']
useless = ['[', ']', '{' , '}', ' ', ',', ';', '\n']
target = ['+', '-', '*', '<', '=', '&']


class Node:
    def __init__(self, name, parent):
        self.n = name
        self.p = parent
        self.c = []


def getNode(line, pos):
    return line[pos + 1:].split(' ')[0]


def getContent(line, pos):
    i = j = pos
    while line[j] not in flags:
        j += 1
    unit = line[i:j]
    return unit


def setNode(dict, key):
    if key in dict:
        dict[key] += 1
    else:
        dict[key]=1
    return key +'\n'+ str[dict[key]]


def ASTDrawer(infile, outfile):
    # Tree Nodes
    nodeStack = []
    nodeDict = {}
    root = setNode(nodeDict, 'root')
    root = Node(root, None)
    pNode = root

    sign = 0
    with open(infile) as fin, open(outfile, 'w') as fout:
        for line in fin:
            i = 0
            while i < len(line):
                if line[i] == '(':
                    if line[i + 1] != ' ':
                        curNode = getNode(line, i)
                        i += len(curNode) + 1
                        curNode = setNode(nodeDict, curNode)
                        curNode = Node(curNode, pNode)
                        pNode.c.append(curNode)
                        pNode = curNode
                    else:
                        sign += 1
                        i += 1
                elif line[i] == ')':
                    if sign == 0:
                        pNode = pNode.p
                    else:
                        sign -= 1
                    i += 1
                elif line[i] in useless:
                    i += 1
                else:
                    Content = getContent(line, i)
                    if Content in target:
                        pNode.n = pNode.n + '\n' + Content
                    i += len(Content) + 1
                    if line[i+1] == ')':
                        pNode = pNode.p


if __name__ == '__main__':
    ASTDrawer(sys.argv[1], sys.argv[2])


