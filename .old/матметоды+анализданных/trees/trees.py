import math
from collections import defaultdict
from collections import Counter
from functools import partial

inputs = [
({ 'level': 'Senior', 'lang': 'Java',   'tweets': 'no', 'phd': 'no'}, False),
({ 'level': 'Senior', 'lang': 'Java',   'tweets': 'no', 'phd': 'yes'}, False),
({ 'level': 'Mid',    'lang': 'Python', 'tweets': 'no', 'phd': 'no'}, True),
({ 'level': 'Junior', 'lang': 'Python', 'tweets': 'no', 'phd': 'no'}, True) ,
({ 'level': 'Junior', 'lang': 'R',      'tweets': 'yes','phd': 'no'} , True) ,
({ 'level': 'Junior', 'lang': 'R',      'tweets': 'yes','phd': 'yes'}, False),
({ 'level': 'Mid',    'lang': 'R' ,     'tweets': 'yes','phd': 'yes'} , True) ,
({ 'level': 'Senior', 'lang': 'Python', 'tweets': 'no' ,'phd': 'no'} , False) ,
({ 'level': 'Senior', 'lang': 'R',      'tweets': 'yes','phd': 'no'} , True) ,
({ 'level': 'Junior', 'lang': 'Python', 'tweets': 'yes','phd': 'no'} , True) ,
({ 'level': 'Senior', 'lang': 'Python', 'tweets': 'yes','phd': 'yes'} , True) ,
({ 'level': 'Mid',    'lang': 'Python', 'tweets': 'no', 'phd': 'yes'}, True),
({ 'level': 'Mid',    'lang': 'Java',   'tweets': 'yes','phd': 'no'}, True),
({ 'level': 'Junior', 'lang': 'Python' ,'tweets': 'no', 'phd': 'yes' } , False)
]

def entropy(class_probabilities):
    return sum(-р * math.log(р, 2) for р in class_probabilities if р)

def class_probabilities(labels):
    total_count = len(labels)
    return [count / total_count for count in Counter(labels) .values()]

def data_entropy(labeled_data):
    labels = [label for _, label in labeled_data]
    probabilities = class_probabilities(labels)
    return entropy(probabilities) 

def partition_entropy(subsets): 
    total_count = sum(len(subset) for subset in subsets)
    return sum(data_entropy(subset) * len(subset) / total_count for subset in subsets)

def partition_by(inputs, attribute):
    groups = defaultdict(list)
    for input in inputs:
        key = input[0] [attribute]
        groups[key] .append(input)
    return groups

def partition_entropy_by(inputs, attribute):
    partitions = partition_by(inputs, attribute)
    return partition_entropy(partitions.values())

for key in ['level', 'lang', 'tweets', 'phd']:
    print(key, partition_entropy_by(inputs, key))

senior_inputs = [(input, label)
                for input, label in inputs if input["level"] == "Senior"]

for key in ['lang', 'tweets', 'phd']:
    print(key, partition_entropy_by(senior_inputs, key))

tweets_inputs = [(input, label)
                for input, label in inputs if input["tweets"] == "yes"]

for key in ['lang', 'phd']:
    print(key, partition_entropy_by(tweets_inputs, key))

def classify(tree, input):
    if tree in [True, False]:
        return tree

    attribute, subtree_dict = tree
    subtree_key = input.get(attribute)

    if subtree_key not in subtree_dict:
        subtree_key = None

    subtree = subtree_dict[subtree_key]
    return classify(subtree, input)

def build_tree_idЗ(inputs, split_candidates=None):
    if split_candidates is None:
        split_candidates = inputs[0][0].keys()

    num_inputs = len(inputs)
    num_trues = len([label for item, label in inputs if label])
    num_falses = num_inputs - num_trues 

    if num_trues==0: return False 
    if num_falses==0: return True 
    if not split_candidates:
        return num_trues >= num_falses

    best_attribute = min(split_candidates,
                        key=partial(partition_entropy_by, inputs))
    partitions = partition_by(inputs, best_attribute)
    new_candidates=[а for а in split_candidates
                    if а != best_attribute]
    
    subtrees = {attribute_value : build_tree_idЗ(subset, new_candidates)
                for attribute_value, subset in partitions.items()}

    subtrees[None] = num_trues > num_falses 
    return (best_attribute, subtrees) 

tree = build_tree_idЗ(inputs) 

print('')

print(classify(tree, { "level" : "Junior",
                "lang" : "Java",
                "tweets" : "yes",
                "phd" : "no"} ))

print(classify(tree, { "level" : "Junior",
                "lang" : "Java",
                "tweets" : "yes",
                "phd" : "yes"} ))

print(classify(tree, {"level" : "Intern"}))
print(classify(tree, {"level" : "Senior"}))

