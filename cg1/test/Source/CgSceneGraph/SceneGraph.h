#ifndef SCENEGRAPH_H
#define SCENEGRAPH_H

#include <vector>
#include <glm/glm.hpp>
#include <string>
#include <stack>
#include "CgSceneGraphEntity.h"
#include "../CgBase/CgBaseRenderableObject.h"
#include "CgBase/CgBaseRenderer.h"

class SceneGraph
{
public:
    SceneGraph();

    void render(CgBaseRenderer* renderer);
    CgSceneGraphEntity* getRootNode();
    std::stack<glm::mat4> getModelviewMatrixStack();
    void setRootNode(CgSceneGraphEntity* root_node);
    void setModelviewMatrixStack(std::stack<glm::mat4> modelview_matrix_stack);
    void addModelviewMatrixStack(glm::mat4 modelview_matrix);

private:
    void pushMatrix(glm::mat4 matrix);
    void popMatrix();
    void applyTransform(glm::mat4 arg);

    CgSceneGraphEntity* m_root_node;
    std::stack<glm::mat4> m_modelview_matrix_stack;
};

#endif // SCENEGRAPH_H
